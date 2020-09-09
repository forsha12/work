#this program is designed to get the stock portfolio of the user and show their total amount of money spent.
#it also shows the percentage of that total they spent on each Exchange Traded Fund
#Paige Forsha 1/27/19

#getting user input
spy = float(input("Enter amount invested in SPY: "))
qqq = float(input("Enter amount invested in QQQ: "))
eem = float(input("Enter amount invested in EEM: "))
vxx = float(input("Enter amount invested in VXX: "))

#getting the total
total = spy + qqq + eem + vxx

#printing out things for the chart
print("ETF \t\t PERCENTAGE")

print("--------------------")

#getting the percentages
pSPY = spy / total
pQQQ = qqq / total
pEEM = eem / total
pVXX = vxx / total

#printing results
print("SPY \t\t {0:10.2%}".format(pSPY))
print("QQQ \t\t {0:10.2%}".format(pQQQ))
print("EEM \t\t {0:10.2%}".format(pEEM))
print("VXX \t\t {0:10.2%}".format(pVXX))
print("\nTOTAL AMOUNT INVESTED \t{0}".format(total))
