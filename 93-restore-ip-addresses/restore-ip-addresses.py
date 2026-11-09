class Solution:
    def restoreIpAddresses(self, s: str) -> List[str]:
        res = []
        
        def is_valid(sub: str) -> bool:
            if not sub:
                return False
            if sub[0] == '0' and len(sub) > 1:
                return False
            return 0 <= int(sub) <= 255

        def backtrack(index: int, path: list):
            if len(path) == 4:
                if index == len(s):
                    res.append('.'.join(path))
                return
            
            # A segment can be 1, 2, or 3 digits long
            for i in range(index, min(index + 3, len(s))):
                sub = s[index:i+1]
                if is_valid(sub):
                    path.append(sub)
                    backtrack(i + 1, path)
                    path.pop()

        backtrack(0, [])
        return res
