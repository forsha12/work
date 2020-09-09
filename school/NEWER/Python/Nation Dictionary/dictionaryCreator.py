#Paige Forsha
#creates a dictionary file from the UN text file
import nation
import pickle

#first creating list of nation objects
infile = open("UN.txt", 'r')
listOfNations = []
for line in infile:
    data = line.split(',')
    nat = nation.Nation(data[0], data[1], data[2], data[3])
    listOfNations.append(nat)
infile.close()

#then creating dictionary from list of objects
nationDict = {nation._name : nation for nation in listOfNations}

#saving dictionary in .dat file
outfile = open("nationDict.dat", 'wb')
pickle.dump(nationDict, outfile)
outfile.close()
