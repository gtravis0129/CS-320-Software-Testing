# CS 320 – Software Testing, Automation, and Quality Assurance

This repository contains artifacts from CS 320: Software Testing, Automation, and Quality Assurance. It includes unit tests and documentation that show how I write tests, analyze requirements, and apply testing strategies.

## Reflection

### How can I ensure that my code, program, or software is functional and secure?

In this course, I ensured that my code was functional by writing unit tests that checked both normal behavior and edge cases. Using JUnit tests for the contact service helped me confirm that adding, updating, and deleting contacts worked as expected and that invalid data was rejected. I also used validation rules (such as maximum lengths and non-null checks) to prevent bad input, and I thought about how someone might misuse the system so I could design tests and checks to protect data and keep the application more secure.

### How do I interpret user needs and incorporate them into a program?

I interpreted user needs by carefully reading the project requirements and turning them into specific rules and test cases. For example, if the requirement said that contact IDs must be unique and cannot be updated, I made sure my code enforced that and that my tests covered those situations. I also used the requirements to decide what should happen when data is missing or too long, so the program behaves in a way that matches what users and stakeholders expect.

### How do I approach designing software?

When I design software, I start by breaking the problem into smaller responsibilities and deciding which classes should handle which tasks. In the contact service project, I separated the contact data model from the service that manages the list of contacts so each class had a clear role. I then wrote tests around that design, which helped guide my code and made it easier to change or extend later. Focusing on simple, modular design and supporting it with tests helps me build software that is easier to maintain and improve.
