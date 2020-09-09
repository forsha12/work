#Paige Forsha
#This program creates a GUI for users to select a rate and a period to calculate the total money had after
#an investment of $10,000 is made.

from tkinter import *

#creates window and lists for list box
window = Tk()
window.title("Investment")
rateList = ["2%", "2.5%", "3%", "3.5%", "4%"]
periodList = ["annually", "semi-annually", "quarterly", "monthly", "weekly"]

#subtitle
Label(window, text="Invest $10,000: ").grid(row=0, column=0, columnspan=3)

#listbox and label for rates
Label(window, text="Interest\n Rate: ").grid(row=1, column=0, padx=5)
conOFlstRates = StringVar()
lstRates = Listbox(window, width=4, height=5, listvariable=conOFlstRates, exportselection=0)
lstRates.grid(row=2, column=0, pady=3, padx = 10)
conOFlstRates.set(tuple(rateList))

#listbox and label for periods
Label(window, text="Compound\n Periods: ").grid(row=1, column=1, padx=5)
conOFlstPeriods = StringVar()
lstPeriods = Listbox(window, width=15, height=5, listvariable=conOFlstPeriods, exportselection=0)
lstPeriods.grid(row=2, column=1, pady=3, padx=10)
conOFlstPeriods.set(tuple(periodList))

#button to start computation
btnCompute = Button(window, text="Calculate\nAmount\nAfter 5\nYears", command=lambda: compute())
btnCompute.grid(row=2, column=2,  pady=5, padx=5)

Label(window, text="Amount after 5 years: ").grid(row=3, column=0, padx=5)

def compute():
    list = getNumberValues()
    rate = float(list[0])
    period = int(list[1])
    print(rate)
    print(period)
    investment = 10000*((1 + (rate/period))**(5*period))

    #output box
    investmentString = StringVar()
    investmentOutput = Entry(window, state="readonly", textvariable=investmentString)
    investmentOutput.grid(row=3, column=1, pady=5)
    investmentString.set("${0:10,.2f}".format(investment))

def getNumberValues():
    # first gets number values for rate and period. rate first, then period
    #both assume highest amount if boxes aren't selected
    rateText = lstRates.get(lstRates.curselection())
    if rateText == "2%":
        rate = .02
    elif rateText == "2.5%":
        rate = .025
    elif rateText == "3%":
        rate = .03
    elif rateText == "3.5%":
        rate = .035
    else:
        rate = .04

    # now for periods
    perText = lstPeriods.get(lstPeriods.curselection())
    if perText == "annually":
        period = 1
    elif perText == "semi-annually":
        period = 2
    elif perText == "quarterly":
        period = 4
    elif perText == "monthly":
        period = 12
    else:
        period = 55

    return [rate, period]
window.mainloop()