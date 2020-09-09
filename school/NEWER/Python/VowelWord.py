#Paige Forsha
'''
The following program uses a Boolean-valued function to determine whether a word input
by the user is a vowel word (contains every vowel).
'''

def isVowelWord(word):
    word = word.upper()
    vowels = ('A', 'I', 'U', 'O', 'E')
    for vowel in vowels:
        if vowel not in word:
            return False
    return True

#Determine if a word contains every vowel
word = input("Enter a word: ")
if isVowelWord(word):
    print(word, "contains every vowel.")
else:
    print(word, "does not contain every vowel.")