

-- Создание таблицы "Отделы"
CREATE TABLE IF NOT EXISTS Departments (
                                           Uuid VARCHAR(255) PRIMARY KEY,
                                           Description VARCHAR(255) NOT NULL
);

-- Создание таблицы "Должности"
CREATE TABLE IF NOT EXISTS Positions (
                                         Uuid VARCHAR(255) PRIMARY KEY,
                                         Description VARCHAR(255) NOT NULL
);

-- Создание таблицы "Сотрудники"
CREATE TABLE IF NOT EXISTS Employees (
                                         Uuid VARCHAR(255) PRIMARY KEY,
                                         FirstName VARCHAR(255) NOT NULL,
                                         LastName VARCHAR(255) NOT NULL,
                                         MiddleName VARCHAR(255),
                                         Birthdate DATE NOT NULL,
    -- Связывание с таблицей "Отделы"
                                         DepartmentUuid VARCHAR(255) REFERENCES Departments (Uuid),
    -- Связывание с таблицей "Должности"
                                         PositionUuid VARCHAR(255) REFERENCES Positions (Uuid),
                                         JobNumber VARCHAR(255) UNIQUE
);



-- Создание таблицы "Контакты"
CREATE TABLE IF NOT EXISTS Contacts (
                                        Uuid VARCHAR(255) PRIMARY KEY,
                                        Type VARCHAR(255) NOT NULL,
                                        Email VARCHAR(255),
                                        Phone VARCHAR(255),
    -- Связывание с таблицей "Сотрудники"
                                        EmployeeUuid VARCHAR(255) REFERENCES Employees (Uuid)
);

-- Создание таблицы "Адреса"
CREATE TABLE IF NOT EXISTS Addresses (
                                         Uuid VARCHAR(255) PRIMARY KEY,
                                         Street VARCHAR(255),
                                         City VARCHAR(255),
                                         State VARCHAR(255),
                                         Zip VARCHAR(255),
    -- Связывание с таблицей "Контакты"
                                         ContactUuid VARCHAR(255) REFERENCES Contacts (Uuid)
);

-- Создание таблицы "Навыки"
CREATE TABLE IF NOT EXISTS Skills (
                                      Uuid VARCHAR(255) PRIMARY KEY,
                                      Category VARCHAR(255) NOT NULL,
                                      Description VARCHAR(255),
    -- Связывание с таблицей "Сотрудники"
                                      EmployeeUuid VARCHAR(255) REFERENCES Employees (Uuid)
);

-- Создание таблицы "Документы"
CREATE TABLE IF NOT EXISTS Documents (
                                         Uuid VARCHAR(255) PRIMARY KEY,
                                         Type VARCHAR(255) NOT NULL,
                                         Description VARCHAR(255),
                                         Number VARCHAR(255),
                                         RegistrationDate DATE,
    -- Связывание с таблицей "Сотрудники"
                                         EmployeeUuid VARCHAR(255) REFERENCES Employees (Uuid)
);