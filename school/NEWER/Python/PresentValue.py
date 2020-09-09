#This program gets the present value of f dollars at a given interest rate compounded annually for a given number of years.
#Paige Forsha 1\27\19


#getting future value, interest rate, and number of years through user input
f = float(input("Enter future value: "))
rate = float(input("Enter interest rate (as %): "))
years = int(input("Enter number of years: "))

#taking input and plugging it into the formula to get the present value
presentValue = f / ((1 + (rate/100))**years)

#printing out result
print("Present value: ${0:10,.2f}".format(presentValue))