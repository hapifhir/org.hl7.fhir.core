Extension: LabelExtension
Id: LabelExtension
Context: Composition.section
* extension 0..0
* value[x] only string
* value[x] 1..1

Profile: NestedComposition
Parent: Composition
Id: NestedComposition
* section ^slicing.discriminator.type = #value
* section ^slicing.discriminator.path = "title"
* section ^slicing.rules = #open
* section contains summary 0..1
* section[summary].title 1..1
* section[summary].title = "Summary" (exactly)
* section[summary].section ^slicing.discriminator.type = #value
* section[summary].section ^slicing.discriminator.path = "title"
* section[summary].section ^slicing.rules = #open
* section[summary].section contains details 0..1
* section[summary].section[details].title 1..1
* section[summary].section[details].title = "Details" (exactly)
* section[summary].section[details].extension contains LabelExtension named label 1..1
* section[summary].section[details].extension[label].valueString 1..1
* section[summary].section[details].extension[label].valueString = "Nested section label" (exactly)
