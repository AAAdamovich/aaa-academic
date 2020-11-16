"""
eightpuzzle.py for Python Homework 2 - "A* Search"
Antony Adamovich
Prof. Richard Burns - CSC 481 - West Chester University
Created: 21-SEP-2019 - Last Edited: 30-OCT-2019
Edited: 30-OCT-2019 - Modification in process of picking next node from 
    frontier. Previously, g(n), or path taken from previous nodes to node
    in frontier, n, was not counted in finding the minimum h value
    in frontier. This generated non-optimal solutions. 
Resources:
    Code structure motivated by Lisa Torrey's 2016 Model AI Assignments
      contribution.
"""

import copy
import time

class Puzzle(): 
    """A sliding-block puzzle."""

    # Cardinal directions for moving around the puzzle
    NORTH = 'N'
    SOUTH = 'S'
    EAST = 'E'
    WEST = 'W'
    CARDINALS = [NORTH, SOUTH, EAST, WEST]

    def __init__(self, grid):
        """Instances differ by their number configurations."""
        self.grid = copy.deepcopy(grid) # No aliasing!
        self.path = list()
    
    def display(self):
        """Print the puzzle."""
        for row in self.grid:
            for number in row:
                print(number, end = " ")
            print()
        print()
    
    def posOf(self, item):
        """Returns the tuple (location in list: (row, comlumn) ) 
        associated with the item query in the puzzle. """
        # For every element (integer) in grid...
        for i in range(len(self.grid)):
            for j in range(len(self.grid[i])):
                if self.grid[i][j] == item:
                    return (i, j)
        # In the event search concluded and item was not found
        return None
    
    def isValid(self, move):
        """ Checks if the position in grid represented by the cardinal "move" 
        is a valid move. In other words, if moving a puzzle piece from "move"
        to the empty space is possible. True if "move" is valid, 
        false otherwise. """
        pos = self.cardinalPos(move)
        return (pos[0] >= 0 and pos[1] >= 0 and pos[0] < len(self.grid) and pos[1] < len(self.grid[0]))
    
    def cardinalPos(self, move):
        """ Return a puzzle location (tuple) that corresponds to self.grid
        (current state) after applying move. NO LIST BOUNDRY CHECKING 
        is performed here. This function may return pairs with 
        negative values or values greater than the length of grid. """
        emptyPair = self.posOf(' ')
        
        if move == self.NORTH:
            return (emptyPair[0] - 1, emptyPair[1])
        if move == self.SOUTH:
            return (emptyPair[0] + 1, emptyPair[1])
        if move == self.EAST:
            return (emptyPair[0], emptyPair[1] + 1)
        if move == self.WEST:
            return (emptyPair[0], emptyPair[1] - 1)
        
    def moves(self):
        """Return a list of possible moves given the current configuration."""
        return list(filter(self.isValid, self.CARDINALS))            
        
    def neighbor(self, move):
        """Return a Puzzle instance like this one but with one move made."""
        # Get position of tile relative to "move"
        nextPos = self.cardinalPos(move)
        # Get position of the empty tile
        emptyPos = self.posOf(' ')
        # Get value (tile number) of the tile in "move" position
        nextValue = self.grid[nextPos[0]][nextPos[1]]
        newPuzzle = Puzzle(self.grid)
        # In new puzzle, assign empty position to moved tile, and vise-versa
        newPuzzle.grid[nextPos[0]][nextPos[1]] = ' '
        newPuzzle.grid[emptyPos[0]][emptyPos[1]] = nextValue
        newPuzzle.path = self.path.copy()
        newPuzzle.path.append(move)
        return newPuzzle
        
    def h(self, goal):
        """Compute the distance heuristic from this instance to the goal.
        Using manhattan distance """
        hSum = 0
        # For every element (integer) in grid...
        for i in range(len(self.grid)):
            for j in range(len(self.grid[i])):
                nextItem = self.grid[i][j]
                # Skip the calculation of h for empty tile
                if(nextItem != ' '):
                    # Get location of self grid item in goal
                    itemPosInGoal = goal.posOf(nextItem)
                    # Compute distance (of item) between goal and self
                    hSum += (abs(itemPosInGoal[0] - i) + abs(itemPosInGoal[1] - j))
                
        return hSum

class Agent():
    """Knows how to solve a sliding-block puzzle with A* search."""
    def astar(self, puzzle, goal):
        """Return a list of moves to get the puzzle to match the goal."""
        frontier = list()
        explored = list()
        # Add start to frontier:
        frontier.append(puzzle)
        current = puzzle
        explored.append(current)
        while frontier != []:

            # Check if goal state has been reached
            if current.grid == goal.grid:
                return current.path
            # Reset minH
            minH = 1000000000;
            for n in range(len(frontier)):
                if (frontier[n].h(goal) + len(frontier[n].path)) < minH:
                    # Smallest heuristic value found so far in frontier
                    minH = (frontier[n].h(goal) + len(frontier[n].path))
                    # Index of smallest heuristic value found so far in frontier
                    minHIndex = n
            current = frontier[minHIndex]
            explored.append(current)
            del frontier[minHIndex];
            # Add all children of current to frontier 
            for child in (list(map(current.neighbor, current.moves()))):
                # Check if child is in explored:
                inExplored = False
                for i in range(len(explored)):
                    if (explored[i].grid == child.grid):
                        inExplored = True
                    
                if (inExplored == False):
                    frontier.append(child)
                    explored.append(child)
            # In the event frontier is exhausted with no path found            
        return None        

def main():
    """Create a puzzle, solve it with A*, and console-animate."""
    puzzle = Puzzle([[3, 6, ' '], [1, 2, 5], [4, 8, 7]])
    agent = Agent()
    goal = Puzzle([[1, 2, 3], [4, 5, 6], [7, 8, ' ']])
    path = agent.astar(puzzle, goal)

    while path:
        move = path.pop(0)
        puzzle = puzzle.neighbor(move)
        time.sleep(1)
        puzzle.display()
    
if __name__ == '__main__':
    main()