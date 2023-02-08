CREATE TABLE `User`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    `mail` VARCHAR(255) NOT NULL,
    `password` VARCHAR(255) NOT NULL,
    `idAllergy` BIGINT NULL,
    `idReservation` BIGINT NULL,
    `isAdmin` TINYINT NOT NULL
);
ALTER TABLE
    `User` ADD PRIMARY KEY `user_id_primary`(`id`);
ALTER TABLE
    `User` ADD UNIQUE `user_mail_unique`(`mail`);
ALTER TABLE
    `User` ADD INDEX `user_idallergy_index`(`idAllergy`);
ALTER TABLE
    `User` ADD INDEX `user_idreservation_index`(`idReservation`);
CREATE TABLE `Dish`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    `image` VARCHAR(255) NULL,
    `title` VARCHAR(255) NOT NULL,
    `description` TEXT NOT NULL,
    `price` DECIMAL(8, 2) NOT NULL,
    `category` VARCHAR(255) NOT NULL
);
ALTER TABLE
    `Dish` ADD PRIMARY KEY `dish_id_primary`(`id`);
CREATE TABLE `Menu`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    `title` VARCHAR(255) NOT NULL,
    `idComposition` BIGINT NOT NULL
);
ALTER TABLE
    `Menu` ADD PRIMARY KEY `menu_id_primary`(`id`);
CREATE TABLE `Composition`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    `price` DECIMAL(8, 2) NOT NULL,
    `description` BIGINT NOT NULL
);
ALTER TABLE
    `Composition` ADD PRIMARY KEY `composition_id_primary`(`id`);
CREATE TABLE `Schedule`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    `opening` VARCHAR(255) NOT NULL,
    `closing` VARCHAR(255) NOT NULL
);
ALTER TABLE
    `Schedule` ADD PRIMARY KEY `schedule_id_primary`(`id`);
ALTER TABLE
    `Schedule` ADD UNIQUE `schedule_opening_unique`(`opening`);
ALTER TABLE
    `Schedule` ADD UNIQUE `schedule_closing_unique`(`closing`);
CREATE TABLE `Allergy`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    `name` BIGINT NOT NULL
);
ALTER TABLE
    `Allergy` ADD PRIMARY KEY `allergy_id_primary`(`id`);
CREATE TABLE `Reservation`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    `numPerson` TINYINT NOT NULL,
    `date` BIGINT NOT NULL,
    `hour` BIGINT NOT NULL,
    `idAllergy` BIGINT NOT NULL,
    `maxNumPerson` TINYINT NOT NULL
);
ALTER TABLE
    `Reservation` ADD PRIMARY KEY `reservation_id_primary`(`id`);
ALTER TABLE
    `User` ADD CONSTRAINT `user_idallergy_foreign` FOREIGN KEY(`idAllergy`) REFERENCES `Allergy`(`id`);
ALTER TABLE
    `Reservation` ADD CONSTRAINT `reservation_idallergy_foreign` FOREIGN KEY(`idAllergy`) REFERENCES `Allergy`(`id`);
ALTER TABLE
    `Menu` ADD CONSTRAINT `menu_idcomposition_foreign` FOREIGN KEY(`idComposition`) REFERENCES `Composition`(`id`);