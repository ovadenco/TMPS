class boss():
    def __init__(self, name):
        self.name = name

    def get_car_without_backseats(self):
        #config#1
        self.name.get_car()
        self.name.add_model()
        self.name.add_engine()
        self.name.add_tire()

    def get_car_with_backseats(self):
        #config#2
        self.name.get_car()
        self.name.add_model()
        self.name.add_engine()
        self.name.add_tire()
        self.name.add_backseats()

    def get_car(self):
        return self.name.car

class builder():
    # generate the class car and hand it over to engine_builder
    def __init__(self, car=None):
        self.car = car

    def get_car(self):
        self.car = car()


class engine_builder(builder):
    # this initialise the attributes of the class
    def add_model(self):
        self.car.model = 'VW'

    def add_engine(self):
        self.car.engine = "1.4"

    def add_tire(self):
        self.car.tire = 'Toyo'
    
    def add_backseats(self):
        self.car.backseats = 'backseats'


class car():
    # this is the core class to be initialised
    def __init__(self):
        self.model = None
        self.engine = None
        self.tire = None
        self.backseats = None

    def __str__(self):
        if self.backseats:
            return f"this is model: {self.model}, engine: {self.engine}, tire: {self.tire} with backseats {self.backseats}"
        else:
            return f"this is model: {self.model}, engine: {self.engine}, tire: {self.tire} with no backseats"

car_obj = car()
carBuilder = engine_builder(car_obj)
build_car = boss(carBuilder)
build_car.get_car_without_backseats()
car_built = build_car.get_car()
print(car_built)

car_obj_backseats = car()
carBuilder = engine_builder(car_obj_backseats)
build_car = boss(carBuilder)
build_car.get_car_with_backseats()
car_built = build_car.get_car()
print(car_built)