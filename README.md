# MarkdownRenderer
This is a project made for my "*Advanced Programming Methods*" university class.

It is made in **Java** (a requirement).
And uses **Swing** as the UI framework.

This Markdown Renderer can also be used as a simple Notepad!

## Downsides
- Does not support the entire Markdown standard.
- Not very performant, the render processing goes through the entire input on 
every change, whereas, it could update dynamically.

## Bugs
- The line height of the text could be very big by default, this is caused because of some `JEditorPane` shenanigans.
