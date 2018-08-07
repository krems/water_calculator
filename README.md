# Water Calculator

### Task description
There is a landscape with hills and pits which have similar square shape. Each position in this landscape has a specified height. Max number of positions is 32000. Height is between 0 and 32000.

For example: the first position has height 5, the second position has height 2. The landscape can be presented as a collection of heights. {5,2,3,4,5,4,0,3,1}

When rain happens, landscape is filled with water. Water is collected inside pits only between hills. For example: collected 9 squares of water.

You need to:
* implement an application which calculates amount of collected water for any landscapes. Water calculator should implement method long calculateWaterAmount(int[] landscape)
* validate correctness of landscape
* cover this application with tests (TDD)
* use maven to build the application

### How to run
App accepts whitespace separated list of landscape heights 

* Clone repo
* Enter the working directory: ``cd water_calculator``
* You may need to make scripts executable: ``chmod +x bin/build.sh && chmod +x bin/run.sh``
* Build & run: ``bin/build.sh && bin/run.sh 5 2 3 4 5 4 0 3 1``
