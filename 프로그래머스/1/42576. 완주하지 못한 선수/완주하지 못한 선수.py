def solution(participant, completion):
    participant_dict = {}
    for i in participant:
        if i not in participant_dict.keys():
            participant_dict[i] = 1
        else:
            participant_dict[i] += 1
    for i in completion:
        participant_dict[i] -= 1
    for i in participant:
        if participant_dict[i] == 1:
            return i