class Solution:
    def insertionSortList(self, head: ListNode | None) -> ListNode | None:
        dummy = ListNode(0)
        prev = dummy  # Tracks the last node in the sorted portion
        
        while head:
            next_node = head.next  # Cache the next node to process
            
            # Optimization: if the current node is greater or equal to the last sorted node,
            # we don't need to scan from the beginning.
            if prev.val >= head.val:
                prev = dummy
            
            # Find the insertion point in the sorted list
            while prev.next and prev.next.val < head.val:
                prev = prev.next
            
            # Insert head into the sorted position
            head.next = prev.next
            prev.next = head
            
            # Move to the next node in the original list
            head = next_node
            
        return dummy.next
