#Paige Forsha

#questions asked
minnesota = input("What is the capital of Minnesota? ")
california = input("What is the capital of California? ")
illinois = input("What is the capital of Illinois? ")
alabama = input("What is the capital of Alabama? ")
mass = input("What is the capital of Massachusetts? ")

#checking for missed questions
missed = 0
if minnesota.lower() != "saint paul":
    missed += 1
    print("The capital of Minnesota is Saint Paul.")
if california.lower() != "sacramento":
    missed += 1
    print("The capital of California is Sacramento.")
if illinois.lower() != "springfield":
    missed += 1
    print("The capital of Illinois is Springfield.")
if alabama.lower() != "montgomery":
    missed += 1
    print("The capital of Alabama is Montgomery.")
if mass.lower() != "boston":
    missed += 1
    print("The capital of Massachusetts is Boston.")

#print final results
print("You missed", missed, "question(s).")

