"""
bfs_maze.py for Python Homework 1 - "Breadth-First Search"
Antony Adamovich
Prof. Richard Burns - CSC 481 - West Chester University
Created: 17-SEP-2019 - Last Edited: 21-SEP-2019
Resources:
    Code structure motivated by Lisa Torrey's 2016 Model AI Assignments
    contribution.
"""
import time

class Maze():
    """A pathfinding problem."""
    
    # A travesable tile in the maze
    FLOOR = ' '
    # A non-traversable tile in the maze
    WALL = 'X'
    # The tile representing the Agent
    AGENT = '*'
    # Cardinal directions for moving around the maze
    NORTH = 'N'
    SOUTH = 'S'
    EAST = 'E'
    WEST = 'W'
    CARDINALS = [NORTH, SOUTH, EAST, WEST]
    
    def __init__(self, grid, location):
        """Instances differ by their current agent locations."""
        self.grid = grid
        self.location = location
        # A list of moves the agent has taken so far
        self.path = list()
        
    def display(self):
        """Print the maze, marking the current agent location."""
        for r in range(len(self.grid)):
            for c in range(len(self.grid[r])):
                if (r, c) == self.location:
                    print(self.AGENT, end=' ')
                else:
                    print(self.grid[r][c], end=' ')
            print()
        print()
    
    def cardinalPos(self, move):
        """ Return a maze location (tuple) that corresponds to self.location
        (agent location) after applying move. NO LIST BOUNDRY CHECKING 
        is performed here. This function may return pairs with 
        negative values or values greater than the length of grid. """
        if move == self.NORTH:
            return (self.location[0] - 1, self.location[1])
        if move == self.SOUTH:
            return (self.location[0] + 1, self.location[1])
        if move == self.EAST:
            return (self.location[0], self.location[1] + 1)
        if move == self.WEST:
            return (self.location[0], self.location[1] - 1)

    def isValid(self, move):
        """ Checks if the position in grid represented by the cardinal move 
        is a valid location for Agent. In other words, if the Agent is able
        to move in the cardinal direction 'move'. True if move is valid, 
        false otherwise. """
        pos = self.cardinalPos(move)
        if (pos[0] >= 0 and pos[1] >= 0 and pos[0] < len(self.grid) and pos[1] < len(self.grid[0]) and self.grid[pos[0]][pos[1]] == self.FLOOR):
            return True
        return False
        
    def moves(self):
        """ Return a list of possible moves given the current agent location. """
        return list(filter(self.isValid, self.CARDINALS))
        
    def neighbor(self, move):
        """ Return another Maze instance with a move made."""
        # Copy maze
        newMaze = Maze(self.grid, self.location)
        # Copy path list to neighbor
        newMaze.path = self.path.copy()
        # Check for validity of requested move
        if newMaze.isValid(move):
            # Set new agent location
            newMaze.location = newMaze.cardinalPos(move)
            # Add move that was executed to path
            newMaze.path.append(move)
        else: 
            print("Illegal move attemped! ")
        return newMaze
        
class Agent():
    """ Knows how to find the exit to a maze with BFS. """
    
    def bfs(self, maze, goal):
        """ Return an ordered list of cardinal moves to get the
        maze to match the goal. """
        # The frontier (queue) for BFS (Breadth-First Search) calculations
        frontier = list()
        # A dictionary for vertices (agent positions) 
        # Ready: -1, Waiting: 0, Processed: 1
        states = {}
        # Initialize all "floor" tiles of the maze to "ready" state
        for r in range(len(maze.grid)):
            for c in range(len(maze.grid[0])):
                if maze.grid[r][c] == Maze.FLOOR:
                    states[(r, c)] = -1
        # Frontier begins with only start vertex (maze)
        frontier.append(maze)
        while frontier != []:
            # Next vertex (maze) to be processed comes off frontier 
            maze = frontier.pop(0)
            # Current vertex state is updated to "waiting"
            states[maze.location] = 0
            
            if maze.location == goal.location:
                return maze.path
            else: 
                # Grab all neighbors as maze objects
                neighbors = list(map(maze.neighbor, maze.moves()))
                for child in neighbors:
                    # Check that child vertex has not been explored yet
                    if states[child.location] < 0:
                        # Add child vertex (maze) to frontier
                        frontier.append(child)
                        # Set vertex state to "waiting"
                        states[child.location] = 0
                # Current vertex processing finished, state is updated
                states[maze.location] = 1
        # In the event the frontier is exhausted and the goal was not found:
        return None

def main():
    """Create a maze, solve it with BFS, and console-animate."""
    grid = ["XXXXXXXXXXXXXXXXXXXX",
            "X     X    X       X",
            "X XXXXX XXXX XXX XXX",
            "X       X X    X X X",
            "X X XXX X   XX X X X",
            "X X   X          X X",
            "X XXX XXXXXXXX  XX X",
            "X XXX    X         X",
            "X    XXX       XXXXX",
            "XXXXX   XXXXX      X",
            "X   XXX X X    X X X",
            "XXX XXX X X XXXX X X",
            "X     X X   XX X X X",
            "XXXXX     XXXX X XXX",
            "X     X XXX        X",
            "X XXXXX X XXXX XXXXX",
            "X X     X  X X     X",
            "X X XXXXXX X XXXXX X",
            "X                  X",
            "XXXXXXXXXXXXXXXXXX X"]
    maze = Maze(grid, (1, 1))
    maze.display()
        
    agent = Agent()
    # Edit this line for goal parameter
    goal = Maze(grid, (19, 18))
    path = agent.bfs(maze, goal)
    while path:
        move = path.pop(0)
        print(move)
        maze = maze.neighbor(move)
        time.sleep(0.25)
        maze.display()
if __name__ == '__main__':
    main()