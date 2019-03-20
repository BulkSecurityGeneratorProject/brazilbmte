import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
// tslint:disable-next-line:no-unused-variable
import { Translate, ICrudGetAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntity } from './tower.reducer';
import { ITower } from 'app/shared/model/tower.model';
// tslint:disable-next-line:no-unused-variable
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface ITowerDetailProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export class TowerDetail extends React.Component<ITowerDetailProps> {
  componentDidMount() {
    this.props.getEntity(this.props.match.params.id);
  }

  render() {
    const { towerEntity } = this.props;
    return (
      <Row>
        <Col md="8">
          <h2>
            <Translate contentKey="brazilbmteApp.tower.detail.title">Tower</Translate> [<b>{towerEntity.id}</b>]
          </h2>
          <dl className="jh-entity-details">
            <dt>
              <span id="towerNumber">
                <Translate contentKey="brazilbmteApp.tower.towerNumber">Tower Number</Translate>
              </span>
            </dt>
            <dd>{towerEntity.towerNumber}</dd>
            <dt>
              <span id="serialNumber">
                <Translate contentKey="brazilbmteApp.tower.serialNumber">Serial Number</Translate>
              </span>
            </dt>
            <dd>{towerEntity.serialNumber}</dd>
            <dt>
              <span id="longitude">
                <Translate contentKey="brazilbmteApp.tower.longitude">Longitude</Translate>
              </span>
            </dt>
            <dd>{towerEntity.longitude}</dd>
            <dt>
              <span id="latitude">
                <Translate contentKey="brazilbmteApp.tower.latitude">Latitude</Translate>
              </span>
            </dt>
            <dd>{towerEntity.latitude}</dd>
            <dt>
              <span id="altitude">
                <Translate contentKey="brazilbmteApp.tower.altitude">Altitude</Translate>
              </span>
            </dt>
            <dd>{towerEntity.altitude}</dd>
            <dt>
              <span id="utmX">
                <Translate contentKey="brazilbmteApp.tower.utmX">Utm X</Translate>
              </span>
            </dt>
            <dd>{towerEntity.utmX}</dd>
            <dt>
              <span id="utmY">
                <Translate contentKey="brazilbmteApp.tower.utmY">Utm Y</Translate>
              </span>
            </dt>
            <dd>{towerEntity.utmY}</dd>
            <dt>
              <span id="progressiveDistance">
                <Translate contentKey="brazilbmteApp.tower.progressiveDistance">Progressive Distance</Translate>
              </span>
            </dt>
            <dd>{towerEntity.progressiveDistance}</dd>
            <dt>
              <span id="isCorner">
                <Translate contentKey="brazilbmteApp.tower.isCorner">Is Corner</Translate>
              </span>
            </dt>
            <dd>{towerEntity.isCorner ? 'true' : 'false'}</dd>
            <dt>
              <span id="corner">
                <Translate contentKey="brazilbmteApp.tower.corner">Corner</Translate>
              </span>
            </dt>
            <dd>{towerEntity.corner}</dd>
            <dt>
              <span id="spanDistance">
                <Translate contentKey="brazilbmteApp.tower.spanDistance">Span Distance</Translate>
              </span>
            </dt>
            <dd>{towerEntity.spanDistance}</dd>
            <dt>
              <span id="towerType">
                <Translate contentKey="brazilbmteApp.tower.towerType">Tower Type</Translate>
              </span>
            </dt>
            <dd>{towerEntity.towerType}</dd>
            <dt>
              <Translate contentKey="brazilbmteApp.tower.towerStructureInfo">Tower Structure Info</Translate>
            </dt>
            <dd>{towerEntity.towerStructureInfo ? towerEntity.towerStructureInfo.id : ''}</dd>
            <dt>
              <Translate contentKey="brazilbmteApp.tower.geometryJson">Geometry Json</Translate>
            </dt>
            <dd>{towerEntity.geometryJson ? towerEntity.geometryJson.id : ''}</dd>
            <dt>
              <Translate contentKey="brazilbmteApp.tower.tender">Tender</Translate>
            </dt>
            <dd>{towerEntity.tender ? towerEntity.tender.id : ''}</dd>
          </dl>
          <Button tag={Link} to="/entity/tower" replace color="info">
            <FontAwesomeIcon icon="arrow-left" />{' '}
            <span className="d-none d-md-inline">
              <Translate contentKey="entity.action.back">Back</Translate>
            </span>
          </Button>&nbsp;
          <Button tag={Link} to={`/entity/tower/${towerEntity.id}/edit`} replace color="primary">
            <FontAwesomeIcon icon="pencil-alt" />{' '}
            <span className="d-none d-md-inline">
              <Translate contentKey="entity.action.edit">Edit</Translate>
            </span>
          </Button>
        </Col>
      </Row>
    );
  }
}

const mapStateToProps = ({ tower }: IRootState) => ({
  towerEntity: tower.entity
});

const mapDispatchToProps = { getEntity };

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(TowerDetail);
