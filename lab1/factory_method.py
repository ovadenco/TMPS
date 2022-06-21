class parrot:
    def __init__(self, name):
        self.name = name

    def speak(self):
        return "when nobody sees"

    def __str__(self):
        return "parrot"


class crow:
    def __init__(self, name):
        self.name = name

    def speak(self):
        return "kar"

    def __str__(self):
        return "crow"


def get_pet(pet="parrot"):
    """the factory method"""

    pets = dict(parrot=parrot("Gummy"), crow=crow("Huginn"))
    return pets[pet]


parrot_pet = get_pet("parrot")
print(f'This is {parrot_pet}, and sounds like {parrot_pet.speak()}')
crow_peg = get_pet("crow")
print(f'This is {crow_peg}, and sounds like {crow_peg.speak()}')