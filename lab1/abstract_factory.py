class cow:
    def __init__(self, name):
        self.name = name

    def speak(self):
        return "cowspeak"
    
    def food(self):
        return "cowfood"

    def __str__(self):
        return "cow"


class mosquito:
    def __init__(self, name):
        self.name = name

    def speak(self):
        return "mosquitospeak"
    
    def food(self):
        return "mosquitofood"

    def __str__(self):
        return "mosquito"


def get_pet(pet="cow"):
    """the factory method"""

    pets = dict(cow=cow("Jessy"), mosquito=mosquito("Draco"))
    return pets[pet]

class petfactory:
    def __init__(self, name):
        self.name = name

    def get_pet_obj(self):
        return get_pet(self.name)

    def get_food(self):
        return get_pet(self.name).food()


class petStore:
    def __init__(self, pet_factory=None):
        self._pet_factory = pet_factory

    def show_pet(self):
        pet = self._pet_factory.get_pet_obj()
        food = self._pet_factory.get_food()

        print(f"the pet is {pet} and the food is {food}, and {pet} speaks {pet.speak()}")

cowClass = petfactory('cow')
petStore(cowClass).show_pet()

mosquitoClass = petfactory('mosquito')
petStore(mosquitoClass).show_pet()






