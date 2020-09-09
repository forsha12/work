#Paige Forsha
salary = float(input("Enter beginning salary: "))
payChange = 10

#getting the pay raise
change = (payChange / 100) * salary
newSalary = salary + change

#getting the pay cut
change = (payChange / 100) * newSalary
finalSalary = newSalary - change

#gets the change
percentChange = (finalSalary / salary)
print("New Salary: ${0:10,.2f}".format(finalSalary))
print("Change: {0:10,.2f}%".format(percentChange))