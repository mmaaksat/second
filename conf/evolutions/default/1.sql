# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table asset (
  id                            bigint auto_increment not null,
  name                          varchar(255),
  constraint pk_asset primary key (id)
);

create table assets_users (
  id                            bigint auto_increment not null,
  login                         varchar(255),
  password                      varchar(255),
  role                          integer,
  asset_id                      bigint not null,
  constraint ck_assets_users_role check ( role in ('2','1')),
  constraint pk_assets_users primary key (id)
);

create table oil_fields (
  id                            bigint auto_increment not null,
  oil_fields_name               varchar(255),
  asset_id                      bigint not null,
  best_margin                   bigint,
  best_scenario                 varchar(255),
  constraint pk_oil_fields primary key (id)
);

create table oil_users (
  id                            bigint auto_increment not null,
  login                         varchar(255),
  password                      varchar(255),
  role                          integer,
  oil_field_id                  bigint not null,
  constraint ck_oil_users_role check ( role in ('2','1')),
  constraint pk_oil_users primary key (id)
);

create table scenarios (
  id                            bigint auto_increment not null,
  number                        varchar(255),
  oil_field_id                  bigint not null,
  tax                           bigint,
  cost                          bigint,
  money_from_bank               bigint,
  duration                      bigint,
  inflation                     bigint,
  start_year                    bigint,
  end_year                      bigint,
  scenario_margin               varchar(255),
  constraint pk_scenarios primary key (id)
);

create table year_records (
  id                            bigint auto_increment not null,
  year                          bigint,
  scenario_id                   bigint not null,
  credit_payments               bigint,
  field_development_cost        bigint,
  year_costs                    bigint,
  oil_sold                      bigint,
  oil_price                     bigint,
  start_year                    bigint,
  income                        bigint,
  year_margins                  bigint,
  constraint pk_year_records primary key (id)
);

alter table assets_users add constraint fk_assets_users_asset_id foreign key (asset_id) references asset (id) on delete restrict on update restrict;
create index ix_assets_users_asset_id on assets_users (asset_id);

alter table oil_fields add constraint fk_oil_fields_asset_id foreign key (asset_id) references asset (id) on delete restrict on update restrict;
create index ix_oil_fields_asset_id on oil_fields (asset_id);

alter table oil_users add constraint fk_oil_users_oil_field_id foreign key (oil_field_id) references oil_fields (id) on delete restrict on update restrict;
create index ix_oil_users_oil_field_id on oil_users (oil_field_id);

alter table scenarios add constraint fk_scenarios_oil_field_id foreign key (oil_field_id) references oil_fields (id) on delete restrict on update restrict;
create index ix_scenarios_oil_field_id on scenarios (oil_field_id);

alter table year_records add constraint fk_year_records_scenario_id foreign key (scenario_id) references scenarios (id) on delete restrict on update restrict;
create index ix_year_records_scenario_id on year_records (scenario_id);


# --- !Downs

alter table assets_users drop foreign key fk_assets_users_asset_id;
drop index ix_assets_users_asset_id on assets_users;

alter table oil_fields drop foreign key fk_oil_fields_asset_id;
drop index ix_oil_fields_asset_id on oil_fields;

alter table oil_users drop foreign key fk_oil_users_oil_field_id;
drop index ix_oil_users_oil_field_id on oil_users;

alter table scenarios drop foreign key fk_scenarios_oil_field_id;
drop index ix_scenarios_oil_field_id on scenarios;

alter table year_records drop foreign key fk_year_records_scenario_id;
drop index ix_year_records_scenario_id on year_records;

drop table if exists asset;

drop table if exists assets_users;

drop table if exists oil_fields;

drop table if exists oil_users;

drop table if exists scenarios;

drop table if exists year_records;

