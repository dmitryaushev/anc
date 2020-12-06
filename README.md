Default admin created in data.sql.\
username - admin@mail.com\
password - Password1

Endpoints:\
GET /admin/get-all-users - show all users, access only for admin;\
GET /admin/get-user/{id} - get user by id, access only for admin;\
DELETE /admin/delete-user/{id} - set user status DELETED, access only for admin;\
PUT /admin/change-user-segment/{id} - set user segment VIP/GENERAL, access only for admin;

POST /user/registration - register new user;\
PUT /user - update authenticated user;\
DELETE /user - delete authenticated user;

POST - /family/create - add family members to authenticated user's family;\
GET - /family/{id} - get family by id;
