class nQueens:
    def __init__(self, size):
        self.size = size
        self.board = [[0] * size for i in range(size)]
        self.has_sol = False
    
    def can_place(self, row, col):
        """Check if a queen can be placed in a given row and column"""

        # left horizontal
        for i in range(col): 
            if self.board[row][i] == 1: 
                return False

        # top left diagonal
        # backwards range since zip stops when either list ends
        for i, j in zip(range(row, -1, -1), range(col, -1, -1)):
            if self.board[i][j] == 1: 
                return False

        # bottom left diagonal
        for i, j in zip(range(row, self.size), range(col, -1, -1)):
            if self.board[i][j] == 1: 
                return False
        
        return True
    
    def _solve(self, col):
        """Recursively solves the n queens problem"""
        # reached the end and finished placing queens
        if col >= self.size:
            return True

        for i in range(self.size):
            if self.can_place(i, col):
                # place a queen
                self.board[i][col] = 1

                # recurse next column
                if self._solve(col + 1): 
                    return True
                
                
                # no solution so reset
                self.board[i][col] = 0
        
        return False

    def solve(self):
        """Runs the recursive solve method"""
        if self._solve(0):
            self.has_sol = True
    
    def has_solution(self):
        """Returns True if a solution was found"""
        return self.has_sol

    def print_board(self):
        """Prints the board of queens"""
        for i in range(self.size):
            print(" ".join(str(x) for x in self.board[i]))


def main():
    q = nQueens(8)
    q.solve()

    if not q.has_solution:
        print("No solution")

    q.print_board()

if __name__ == "__main__":
    main()
