#Paige Forsha
#Nation class to hold info to create objects for each nation from the UN text file
#doesn't need to be ran
class Nation:
    def __init__(self, name, continent, population, area):
        self._name = name
        self._continent = continent
        self._population = population
        self._area = area
#gives density
    def popDensity(self):
        return float((float(self._population) * 1000000) / float(self._area))
    def infoPrint(self):
        print("Country: ", self._name)
        print("Continent: ", self._continent)
        print("Population ", self._population)
        print("Area: ", self._area)

