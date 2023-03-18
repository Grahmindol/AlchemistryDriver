this is just a mod.

component:

- atomizer
	canProcess():boolean -- Return if atomizer can process.
	getInputTankInfo():table -- Get some information about this tank.
	getEnergyStored():number -- Returns the amount of stored energy.
	getMaxEnergyStored():number -- Returns the maximum amount of stored energy.

- liquifier
	canProcess():boolean -- Return if liquifier can process.
	getOutputTankInfo():table -- Get some information about this tank.
	getEnergyStored():number -- Returns the amount of stored energy.
	getMaxEnergyStored():number -- Returns the maximum amount of stored energy.

- evaporator
	getInputTankInfo():table -- Get some information about this tank.
	canProcess():boolean -- Return if evaporator can process.

- electrolyzer
	canProcess():boolean -- Return if electrolyzer can process.
	getInputTankInfo():table -- Get some information about this tank.	
	getEnergyStored():number -- Returns the amount of stored energy.
	getMaxEnergyStored():number -- Returns the maximum amount of stored energy.

- fission_controller
	canProcess():boolean -- Return if fission controller can process.
	getEnergyStored():number -- Returns the amount of stored energy.
	getMaxEnergyStored():number -- Returns the maximum amount of stored energy.

- fusion_controller
	canProcess():boolean -- Return if fusion controller can process.
	getEnergyStored():number -- Returns the amount of stored energy.
	getMaxEnergyStored():number -- Returns the maximum amount of stored energy.

- dissolver
	canProcess():boolean -- Return if dissolver can process.
	getEnergyStored():number -- Returns the amount of stored energy.
	getMaxEnergyStored():number -- Returns the maximum amount of stored energy.

- combiner
	canProcess():boolean -- Return if combiner can process.
	getEnergyStored():number -- Returns the amount of stored energy.
	getMaxEnergyStored():number -- Returns the maximum amount of stored energy.
	getRecipeIsLocked():boolean -- Returns if the recipe is locked
	setRecipeIsLocked(boolean:locked):boolean -- Set and Returns if the recipe is locked
	getCurrentRecipe():boolean[,string] -- Returns  the name of recipe's output item
	setCurrentRecipe(string:name):boolean -- Returns if recipe was modified
	
	 
	