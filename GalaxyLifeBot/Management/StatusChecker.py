from Management import PictureReader


# Ilość złota
def getGold():
    return PictureReader.readNumbers(1090, 106, 90, 20)


# Ilość kryształów
def getCrystals():
    return PictureReader.readNumbers(940, 106, 90, 20)


# Nazwa budynku
def getBuildingName():
    return PictureReader.read(610, 420, 300, 18)


# Czas budowy
def getBuildingUpgradeTime():
    return PictureReader.read(990, 665, 300, 18)


# Koszt budowy
def getBuildingUpgradeCost():
    return PictureReader.read(990, 720, 300, 18)