# My Personal Project

## A subtitle

A *bulleted* list:
- item 1
- item 2
- item 3

An example of text with **bold** and *italic* fonts.  

The purpose of this application will be to allow people to design custom PCs. The goal is to allow people to design multiple PCs, as well as customize, name and sort through them. The setup will have a list of PCs, each PC object will be made up of many different components. The target audience of this application will be people who want to use custom PCs. This could include people who will use these custom PCs for activites like gaming, animation, and other such activities, as well as business who might be interested in large amounts of custom PCs. This project is of interest to me because I do have an interest in activities such as gaming, as well my personal desktop is a custom PC. As well I am very interested in how computer work, and I would like to design an App that would make that task easier.

## User Stories 
As a user I would like to create a list of PCs

As a user I would like to add a PC to a list of PCs

As a user I would like to view a list of PCs and be able to see the individual cost of each one

As a user I would like to add an processor to a PC called "gaming PC"

As a user I would like to take said PC and copy 10 times

As a user I would like to remove said PC

As a user I would like to save my list of PCs

As a user I would like to be able to log in and access my previously worked on list of PCs

*I'm so sorry for the TA who has to mark all of this*

# Instructions for Grader

- You can generate the first required action related to the user story "adding multiple Xs to a Y" by pressing button "Add PC"
- You can generate the second required action related to the user story "adding multiple Xs to a Y" by pressing button "View PC"
- You can locate my visual component by pressing the Add PC button, which will load up an image of the PC
- You can save the state of my application by pressing the "Save PC" button
- You can reload the state of my application by pressing the "Load PC" button

Phase 4, Task 2:
Tue Aug 06 21:27:41 PDT 2024
Added PC pc1

Tue Aug 06 21:27:46 PDT 2024
Selected PC pc1

Tue Aug 06 21:27:54 PDT 2024
Added Case case

Tue Aug 06 21:27:58 PDT 2024
Added CPU intel i5

Tue Aug 06 21:28:07 PDT 2024
Saved file

Tue Aug 06 21:28:11 PDT 2024
Copied PC pc1

Phase 4 Task 3:
Given more time on this project, I would have conducted a massive amount of refactoring. I finished phase 1 before I understood interfaces, abstracts and extends. For my class PC, the individual parts in it were relatively similar, sharing 2 common methods, getCost() and getModel() (OperatingSystem's getSystemName() method is functionally the same to getModel()) with the other methods being relatively similar stats. Doing this would allowed me to shink my PC function by at least 75%, massively increasing cohension in the code. Instead of having individual add(insert part)() and remove(insert part)() methods for each and every part, it could have simply be addPart() and removePart() with Part being a common interface. Furthermore, this would have allowed to massively cutdown on code in other parts of the code. Anywhere with functions that take one of the many implementation of Parts could have been condensed into one function instead of many. Another thing I would have done is to improve the UI. The UI as is stands works, but is massively chunky, requiring to constantly press "View PC" to get updates on parts. Furthermore, the "View PC" button doesn't open up one window but as many windows as there are PCs. Another thing that we learned too late in the course to be useful would be the Observable and Observer interfaces, many times in my code, if I had constantly updating code, I could have made my UI much more efficient. 