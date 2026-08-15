class Solution:
    def solveNQueens(self, n: int):
        board = [["."] * n for _ in range(n)]

        cols = set()
        diag = set()      # row - col
        anti = set()      # row + col

        ans = []

        def backtrack(row):
            if row == n:
                ans.append(["".join(r) for r in board])
                return

            for col in range(n):
                if (col in cols or
                    row - col in diag or
                    row + col in anti):
                    continue

                board[row][col] = "Q"
                cols.add(col)
                diag.add(row - col)
                anti.add(row + col)

                backtrack(row + 1)

                board[row][col] = "."
                cols.remove(col)
                diag.remove(row - col)
                anti.remove(row + col)

        backtrack(0)
        return ans