#Paige Forsha
#This program will take 3 inputs and print out the monthly payment based on the loan, the rate, and the years.
#A GUI
from tkinter import *

window = Tk()
window.title("Car Loan")

#builds grid to enter input
enloan = Entry(window, width=10)
enloan.grid(row=0, column=1, padx=4, pady=5, sticky=W)
Label(window, text="Amount of loan: ").grid(row=0, column=0, padx=10)
enr = Entry(window, width=5)
enr.grid(row=1, column=1, padx=4, pady=5, sticky=W)
Label(window, text="Interest Rate (as %): ").grid(row=1, column=0, padx=10)
enyears = Entry(window, width=2)
enyears.grid(row=2, column=1, padx=4, pady=5, sticky=W)
Label(window, text="Number of Years: ").grid(row=2, column=0, padx=10)
btnComputer = Button(window, text = "Calculate Monthly Payment", command=lambda: computePayment(enloan, enr, enyears))
btnComputer.grid(row=3, column=0, columnspan=2, pady=5)


#computes the payment and prints the output after button is pressed
def computePayment(l, rate, yrs):
    loan = float(l.get())
    r = float(rate.get())
    years = int(yrs.get())

    #i = r/100, as per instructions
    i = r / 100
    payment = (i / (1-(1+i)**(-12 * years))) * loan
    payString = StringVar()
    paymentOutput = Entry(window, state="readonly", textvariable=payString)
    paymentOutput.grid(row=4,column=0,columnspan=2,pady=5)
    payString.set("${0:10,.2f}".format(payment))

window.mainloop()