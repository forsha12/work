#Paige Forsha
from tkinter import *

window = Tk()
window.title("Full Name")

#name entry labels and boxes
lastName = Entry(window, width=20)
lastName.grid(row=0, column=1, padx=4, pady=5, sticky=W)
Label(window, text="Last name: ").grid(row=0, column=0, padx=10)
firstName = Entry(window, width=20)
firstName.grid(row=1, column=1, padx=4, pady=5, sticky=W)
Label(window, text="First Name: ").grid(row=1, column=0, padx=10)

#button to start name computation
btnCompute = Button(window, text="Display Full Name", command=lambda: compute())
btnCompute.grid(row=2, column=1,  pady=5, padx=5)

Label(window, text="Full name: ").grid(row=3, column=0, padx=5)

#name joining together for full
def compute():
    full = firstName.get() + " " + lastName.get()

    fullName = StringVar()
    fullNameOutput = Entry(window, state="readonly", textvariable=fullName)
    fullNameOutput.grid(row=3, column=1, pady=5)
    fullName.set(full)

window.mainloop()