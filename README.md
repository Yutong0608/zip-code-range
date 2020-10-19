# zip-code-range
BACKGROUND
Sometimes items cannot be shipped to certain zip codes, and the rules for these restrictions are stored as a series of ranges of 5 digit codes. For example if the ranges are:

[94133,94133] [94200,94299] [94600,94699]

Then the item can be shipped to zip code 94199, 94300, and 65532, but cannot be shipped to 94133, 94650, 94230, 94600, or 94299.

Any item might be restricted based on multiple sets of these ranges obtained from multiple sources.

PROBLEM
Given a collection of 5-digit ZIP code ranges (each range includes both their upper and lower bounds), provide an algorithm that produces the minimum number of ranges required to represent the same restrictions as the input.

NOTES
- The ranges above are just examples, your implementation should work for any set of arbitrary ranges
- Ranges may be provided in arbitrary order
- Ranges may or may not overlap
- Your solution will be evaluated on the correctness and the approach taken, and adherence to coding standards and best practices

EXAMPLES:
If the input = [94133,94133] [94200,94299] [94600,94699]
Then the output should be = [94133,94133] [94200,94299] [94600,94699]

If the input = [94133,94133] [94200,94299] [94226,94399] 
Then the output should be = [94133,94133] [94200,94399]

Evaluation Guidelines:
Your work will be evaluated against the following criteria:
- Successful implementation
- Efficiency of the implementation
- Design choices and overall code organization
- Code quality and best practices

# Assumption
Input: Assumed the input is String, and if the input is null, it would throw IllegalArgumentException exception

Output: the output is String

Zip code should be positive number

Zip code range should be valid, which means the there are only lower bound and upper bound exist and lower bound should not be greater than the upper bound
Duplicate zip code ranges are a possibility.

# Data Structure
ArrayList to implement the List interface

# Approach
- First convert the input of String to the List of Range(Range is the custom class), and check the validation of the input
- Then sort the each Range according to the ascending order of the lower bound, and traverse the whole List
- If the Range intervals is disjoint, then add the the range to the result, otherwise update the upper bound if needed
- Finally output the String via the toString method in the Range class

# Test
- Junit 5 with annotation of @AfterEach @BeforeEach @Test
- check the corner case of when input is null, String with 0 length, negative zip code, invalid range of zip code (lower bound greater than upper bound, don't have lower bound or upper bound, have more than 2 bounds)
- check the general test cases of 

input1 = [94133,94133] [94200,94299] [94600,94699]
output1 = [94133,94133] [94200,94299] [94600,94699]

input2 = [94133,94133] [94200,94299] [94226,94399] 
output2 = [94133,94133] [94200,94399]

# Time Complexity & Space Complexity
- Time complexity: O(nlog(n)) because the Collection.sort has been used
- Space complexity: O(n) because the output List of Range would be created
