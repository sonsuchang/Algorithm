N = int(input())
words_dict = {}
sort_word_dict = {}
for _ in range(N):
    word = [input()]
    if len(word[0]) in words_dict.keys():
        if word[0] not in words_dict[len(word[0])]:
            words_dict[len(word[0])] = sorted(words_dict[len(word[0])] + word)
    else:
        words_dict[len(word[0])] = word
sort_word_dict = sorted(words_dict.items())
print_words = []
for i in range(len(sort_word_dict)):
    print_words += sort_word_dict[i][1]
for k in range(len(print_words)):
    print(print_words[k])
