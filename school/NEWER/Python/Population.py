#Paige Forsha
#This program finds out when the population will reach 8 billion and 9 billion people
population = 7000000
growth = .011
year = 2011

#this loop adds 1.1% to the population every year, counting up the years until 8 billion is hit
while population <= 8000000:
    population = (population * growth) + population
    year += 1

print("The year of", year, "is when the population reaches approximately 8 billion.")
#print(population)
#was checking the math

#same loop as before, but stops at 9 billion to check
while population <= 9000000:
    population = (population * growth) + population
    year += 1
print("The year of", year, "is when the population reaches approximately 9 billion.")
#print(population)
#was checking the math
