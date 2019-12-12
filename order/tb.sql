DROP TABLE IF EXISTS `tb_item`;
CREATE TABLE `tb_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `name` varchar(100) NOT NULL COMMENT '商品名字',
  `num` bigint(10) NOT NULL COMMENT '库存数量',
  `created` datetime NOT NULL COMMENT '创建时间',
  `updated` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='商品表';

DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE `tb_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单id',
   `state` int(1) NOT NULL COMMENT '订单状态',
  `created` datetime NOT NULL COMMENT '创建时间',
  `updated` datetime NOT NULL COMMENT '更新时间',
primary key(`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='订单表';


DROP TABLE IF EXISTS `tb_order_detail`;
CREATE TABLE `tb_order_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单详情id',
  `order_id` bigint(20) not null comment '订单id',
  `item_id` bigint(20) not null comment '商品id',
    `num` bigint(10) NOT NULL COMMENT '商品数量',
  `created` datetime NOT NULL COMMENT '创建时间',
  `updated` datetime NOT NULL COMMENT '更新时间',
primary key(`id`),
foreign key(`order_id`) references tb_order(`id`) ,
foreign key(`item_id`) references tb_item(`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='订单详情表';


