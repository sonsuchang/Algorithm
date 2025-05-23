from collections import deque

def get_max_reward(number, swap_count):
    queue = deque()
    queue.append((number, 0))
    visited = [set() for _ in range(swap_count + 1)]
    visited[0].add(number)

    max_value = 0

    while queue:
        curr, count = queue.popleft()

        if count == swap_count:
            max_value = max(max_value, int(curr))
            continue

        num_list = list(curr)
        n = len(num_list)

        for i in range(n):
            for j in range(i + 1, n):
                num_list[i], num_list[j] = num_list[j], num_list[i]
                new_num = ''.join(num_list)

                if new_num not in visited[count + 1]:
                    visited[count + 1].add(new_num)
                    queue.append((new_num, count + 1))

                num_list[i], num_list[j] = num_list[j], num_list[i]

    return max_value

T = int(input())
for case_num in range(1, T + 1):
    number_str, k = input().split()
    k = int(k)
    result = get_max_reward(number_str, k)
    print(f"#{case_num} {result}")
