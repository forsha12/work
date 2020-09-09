#Paige Forsha
price = 19.95
discountPercent = 30
markdown = (discountPercent / 100) * price
price = price - markdown
print("${0:10,.2f}".format(price))
