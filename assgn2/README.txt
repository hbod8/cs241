Harry Saliba, Jax Rounds

We were unable to fully test HashTable.delete() although it should work under any normal case.

add O(1)
delete O(1)
highcount O(n)
get_avg_successful_search O(n)
get_avg_unsuccessful_search O(n)

We tested our program mostly by testing our hash algorithm, we tested cases where the word had the same letters but different order, and made sure that the data type never overloaded because it was unsigned. We also made sure that there were no long wait times on the program by finding every word in the book.
