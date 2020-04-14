# Algorithm Interview Notes

## [The Algorithm of an Algorithm](https://medium.com/outco/the-algorithm-of-an-algorithm-28043fe47b51)

1. Ask more questions
    - Establish understanding of problem and constraints
    - Similar problems? What stands out?
    - Start with time and space constraints
    - Array: Sorted? Does it contain only numbers? Integers? Positive or negative? Max Lf you have ength? Range of input size?
    - Strings: Distinction between upper/lower case. Spaces? Punctuations?
    - General: Edge cases like empty strings, empty  arrays, very large or very small inputs
    - Language specific questions: Can you use certain libraries? How should you handle errors? What kinds of inputs should your function handle?
    - Pair programming: Can you google syntax and docs? Can you run code with examples?

2. Brain dump
    - Patterns you notice, constraints given, hunches, ideas or thoughts
    - Building blocks of solution

3. Try more examples
    - As you add more dots and make more connections, patterns start to emerge
    - Function is a black box
    - Foundation of Test Driven Development. Have expectations for outputs given inputs and write a function that fulfills those different test cases
    - Scientific mindset. Form hypothesis and test hypothesis
    - Trying more examples reduces overfitting
    - Try to break algorithms with edge cases

4. Become the algorithm
    - Focus on solving one example yourself 
    - ["Thinking outside the box"](https://www.youtube.com/watch?v=zDZFcDGpL4U)
    - Enjoy the challenge and remember why you like solving interesting problems

5. Distill the Problem to its Essence
    - Boil solution down to one or a few sentences
    - "Iterate over the array, keeping track of the largest number you've seen so far, updating it when you see a larger one"
    - Break large, complex problems into smaller, distinct pieces.
    - Find the **keystone piece of information**
    - Express WHAT your algorithm will do, not HOW it will do it

6. Pseudocoding
    - The "HOW" of the problem
    - Goal is to not have to think about syntax while solving the problem and writing out the steps

7. Coding
    - If everything up to this point is done right, should be trivial.
    - Clean and DRY.
    - Style points 
    - Code clarity over one-liners

- Extra Tips
    - Try solving similar problems to build flexibility and comfort
        - Wrote a min heap, try writing max heap
        - know quicksort, try mergesort
    - Start looking for patterns of space and time complexity
        - Constant space = few auxiliary variables
        - Linear space means dictionary or array
        - Linear time means one iteration or some fixed number that doesn't scale w/ input size
        - log(n) time implies some kind of binary search
    - Daily algorithm is a good habit