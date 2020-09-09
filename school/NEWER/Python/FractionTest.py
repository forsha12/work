#Paige Forsha
import unittest


class Fraction:
    def __init__(self):
        self._numerator = 0
        self._denominator = 1

    def setNumerator(self, numerator):
        self._numerator = numerator

    def getNumerator(self):
        return self._numerator

    def setDenominator(self, denominator):
        self._denominator = denominator

    def getDenominator(self):
        return self._denominator

    def getValue(self):
        return self._numerator/self._denominator

    # Greatest Common Divisor
    def GCD(self, m, n):
        while n != 0:
            t = n
            n = m % n
            m = t
        return m

    def reduce(self):
        gcd = self.GCD(self._numerator, self._denominator)
        self._numerator = int(self._numerator / gcd)
        self._denominator = int(self._denominator / gcd)

    def __str__(self):
        return "Numerator: " + str(self._numerator) + "\tDenominator: " + str(self._denominator)


fractionObject = Fraction()


class Tester(unittest.TestCase):
    def testReduce1(self):
        fractionObject.setNumerator(numerator=4)
        fractionObject.setDenominator(denominator=12)
        Fraction.reduce(fractionObject)
        self.assertEqual(fractionObject.getValue(), 1/3)


unittest.main()
