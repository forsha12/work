#Paige Forsha
def main():
    num = int(input("Enter a number: "))
    if isOdd(num):
        print(num, "is an odd number.")
    else:
        print(num, "is an even number.")

def isOdd(x):
    if x % 2 == 0:
        return False
    else:
        return True
# define an isOdd function that will check the given number
# and will return a boolean value of True or False
...
...
...

main()