#Paige Forsha
#Displays information about the country after given a country name. Based on dictionary created.
#run after dictionaryCreator.py

import pickle

#getting dictionary
infile = open("nationDict.dat", 'rb')
nations = pickle.load(infile)
infile.close()

#asks for the country
nat = input("Enter a country name: ")
while nat not in nations:
    print("Not within the dictionary. Renter.")
    nat = input("Enter a country name: ")

#prints out info for it
nations[nat].infoPrint()