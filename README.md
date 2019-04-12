# Item Modifier

I was tasked with creating this plugin to demonstrate my ability for the LiquidPVP lead developer
```
Prompt: "A renaming plugin where instead of using color codes, you can have aliases in asterisks.
An example would be *orange* instead of &6"
```

I made that, and also decided to throw in some configuration, and a command to set lore. 

Commands:
  - /setname [New display name]
      > Description: Sets or removes the name from your item.
      
      > Permission: itemmodifier.setname
      
      > Notes: To remove a name, just use `/setname` with no other arguments
      
  - /setlore [New lore]
      > Description: Sets or removes the lore from your item.
      
      > Permission: itemmodifier.setlore
      
      > Notes: 
        To remove a lore, just use `/setlore` with no other arguments. 
        If you wish to have a new line, use `\n`.
        New lines do not carry over color data, though I may add that in the future.
        
I may turn this into a full fledged project in the future, but at the moment I don't have time.
