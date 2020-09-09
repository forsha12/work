#Paige Forsha
bill = float(input("Enter bill amount: "))
tipPercent = .15

tip = bill * tipPercent
if tip < 2:
    tip = 2


print("Tip: ${0:10,.2f}".format(tip))