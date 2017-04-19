# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table assets (
  id                            bigint auto_increment not null,
  name                          varchar(255),
  constraint pk_assets primary key (id)
);

create table oil_fields (
  id                            bigint auto_increment not null,
  oil_fields_name               varchar(255),
  assets_id                     bigint,
  best_margin                   bigint,
  best_scenario                 varchar(255),
  constraint pk_oil_fields primary key (id)
);

create table scenarios (
  id                            bigint auto_increment not null,
  number                        varchar(255),
  oil_fields_id                 bigint,
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

create table user (
  id                            bigint auto_increment not null,
  login                         varchar(255),
  password                      varchar(255),
  role_id                       bigint,
  assets_or_oil_id              bigint,
  type                          bigint,
  constraint pk_user primary key (id)
);

create table year_records (
  id                            bigint auto_increment not null,
  year                          bigint,
  scenario_id                   bigint,
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


# --- !Downs

drop table if exists assets;

drop table if exists oil_fields;

drop table if exists scenarios;

drop table if exists user;

drop table if exists year_records;

