# Paige Forsha
# This program requests the name of a continent and then prints out the 5 most densly populated countries in that continent
#run after dictionaryCreator.py

import pickle

# getting dictionary
infile = open("nationDict.dat", 'rb')
nations = pickle.load(infile)
infile.close()


# for making a new dictionary with just the nations in a continent
def makeContinentNations(nations, continent):
    contDict = {}
    for nat in nations:
        if nations[nat]._continent == continent:
            contDict[nat] = nations[nat]
    return contDict

#gets continent, sends to make new dictionary
continent = input("Enter the name of a continent that isn't Antarctica: ")
continentDict = makeContinentNations(nations, continent)

#moves dictionary into a sorted one. sorts by population density
newContDict = {continentDict[nation].popDensity(): nation for nation in continentDict}
continentList = sorted(newContDict.items(), reverse=True)

#prints nations with highest population densities within selected continent
print("Highest population densities in selected continent: ")
print(continentList[0])
print(continentList[1])
print(continentList[2])
print(continentList[3])
print(continentList[4])
