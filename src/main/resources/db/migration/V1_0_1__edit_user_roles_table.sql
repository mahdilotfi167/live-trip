-- ----------------------------
-- Rename table user_roles
-- ----------------------------
RENAME TABLE `user_roles` TO `user_authorities`;
ALTER TABLE user_authorities
    RENAME COLUMN roles TO authorities;