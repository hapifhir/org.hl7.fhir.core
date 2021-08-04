* Conversion context added to conversions process
* Users can now define custom behavior for CodeSystems, Extensions, BundleEntries, and Types
* Conversions are threadsafe, each using their own instance of the conversion context that is unique
* ConversionFactory classes are statically accessed, to minimize changes downstream
* I need to add more tests, there were very few to begin with, and it's my next task
* All conversion libraries and no play makes Mark a dull boy