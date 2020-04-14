# Algorithm Interview Notes

## [The Algorithm of an Algorithm](https://medium.com/outco/the-algorithm-of-an-algorithm-28043fe47b51)

1. Ask more questions
    a. Establish understanding of problem and constraints
    b. Similar problems? What stands out?
    c. Start with time and space constraints
    d. Array: Sorted? Does it contain only numbers? Integers? Positive or negative? Max Lf you have ength? Range of input size?
    e. Strings: Distinction between upper/lower case. Spaces? Punctuations?
    f. General: Edge cases like empty strings, empty  arrays, very large or very small inputs
    e. Language specific questions: Can you use certain libraries? How should you handle errors? What kinds of inputs should your function handle?
    g. Pair programming: Can you google syntax and docs? Can you run code with examples?

2. Brain dump
    a. Patterns you notice, constraints given, hunches, ideas or thoughts
    b. Building blocks of solution

3. Try more examples
    a. As you add more dots and make more connections, patterns start to emerge
    b. Function is a black box
    c. Foundation of Test Driven Development. Have expectations for outputs given inputs and write a function that fulfills those different test cases
    d. Scientific mindset. Form hypothesis and test hypothesis
    e. Trying more examples reduces overfitting
    f. Try to break algorithms with edge cases

4. Become the algorithm
    a. Focus on solving one example yourself 
    b. ["Thinking outside the box"](https://www.youtube.com/watch?v=zDZFcDGpL4U)
    c. Enjoy the challenge and remember why you like solving interesting problems

5. Distill the Problem to its Essence
    a. Boil solution down to one or a few sentences
    b. "Iterate over the array, keeping track of the largest number you've seen so far, updating it when you see a larger one"
    c. Break large, complex problems into smaller, distinct pieces.
    d. Find the **keystone piece of information**
    e. Express WHAT your algorithm will do, not HOW it will do it

6. Pseudocoding
    a. The "HOW" of the problem
    b. Goal is to not have to think about syntax while solving the problem and writing out the steps

7. Coding
    a. If everything up to this point is done right, should be trivial.
    b. Clean and DRY.
    c. Style points 
    d. Code clarity over one-liners

Extra Tips
    - Try solving similar problems to build flexibility and comfort
        - Wrote a min heap, try writing max heap
        - know quicksort, try mergesort

    - Start looking for patterns of space and time complexity
        - Constant space = few auxiliary variables
        - Linear space means dictionary or array
        - Linear time means one iteration or some fixed number that doesn't scale w/ input size
        - log(n) time implies some kind of binary search
    
    - Daily algorithm is a good habit