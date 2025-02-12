def solution(genres, plays):
    answer = []
    album = {}
    most_genres = {}
    length = len(genres)
    for i in range(length):
        if genres[i] not in most_genres:
            most_genres[genres[i]] = plays[i]
        else:
            most_genres[genres[i]] += plays[i]
        if genres[i] not in album:
            album[genres[i]] = [[i, plays[i]]]
        else:
            album[genres[i]].append([i, plays[i]])
    target = sorted(most_genres.items(), key = lambda x : x[1], reverse = True)
    for i in target:
        album[i[0]].sort(key = lambda x : x[1], reverse = True)
        cnt = 0
        for j in album[i[0]]:
            if cnt == 2:
                break
            answer.append(j[0])
            cnt += 1
    return answer