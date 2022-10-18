from Management import MessageManagement
from Activities import Minerals, Fixer, Planet, Building
import time

# Configurable parameters
time_before_start = 5
time_after_end = 1
want_upgrade = None  # []


# Do not touch, pls
num_of_iterations = 0
first_run_time = MessageManagement.getTime()

# Start of the program
print("Program rozpocznie działanie za " + str(time_before_start) + "s.")
time.sleep(5)


while 1:
    # Stats of the program and the player
    MessageManagement.sendLine("{=== Wykonałem " + str(num_of_iterations) + " pętli od " + first_run_time + " ===}", 1)
    MessageManagement.sendStatus()

    # Count numbers of iterations done by code and wait
    num_of_iterations += 1
    time.sleep(time_before_start)

    # Removes interrupting elements
    MessageManagement.sendLine("I - Eliminuje niedogodności.", 1)
    Fixer.go()

    # Collecting coins and minerals
    MessageManagement.sendLine("II - Zbieram minerały.", 1)
    Minerals.collect()

    # Waiting 3 seconds to start building
    MessageManagement.sendLine("Ulepszanie rozpocznie się za 3s.", 2)
    time.sleep(3)

    # Upgrading buildings
    MessageManagement.sendLine("------------------")
    MessageManagement.sendLine("III - Rozpoczynam ulepszanie:", 1)
    if want_upgrade:
        # Building.upgradeQuery(want_upgrade)
        pass
    else:
        Building.upgrade("farms/house.png")
        Building.upgrade("farms/mine.png")
    MessageManagement.sendLine("------------------", 2)

    # Iteration done, waiting for a new one
    MessageManagement.sendLine("Pętla zakończona. Następna rozpocznie się za " + str(time_after_end) + "s.")
    MessageManagement.sendLine("===========================================", 2)
    time.sleep(time_after_end)
