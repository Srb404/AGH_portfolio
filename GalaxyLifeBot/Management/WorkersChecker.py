from Management import FindPicture


def getNumber():
    # Returns number of available workers
    if FindPicture.get("workers/workers2.png", 724, 106, 35, 18, 0.75):
        return 2
    elif FindPicture.get("workers/workers1.png", 724, 106, 35, 18, 0.75):
        return 1
    else:
        return 0
