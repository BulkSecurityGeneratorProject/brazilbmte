import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
// tslint:disable-next-line:no-unused-variable
import { Translate, ICrudGetAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntity } from './geometry.reducer';
import { IGeometry } from 'app/shared/model/geometry.model';
// tslint:disable-next-line:no-unused-variable
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface IGeometryDetailProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export class GeometryDetail extends React.Component<IGeometryDetailProps> {
  componentDidMount() {
    this.props.getEntity(this.props.match.params.id);
  }

  render() {
    const { geometryEntity } = this.props;
    return (
      <Row>
        <Col md="8">
          <h2>
            <Translate contentKey="brazilbmteApp.geometry.detail.title">Geometry</Translate> [<b>{geometryEntity.id}</b>]
          </h2>
          <dl className="jh-entity-details">
            <dt>
              <span id="geometryJson">
                <Translate contentKey="brazilbmteApp.geometry.geometryJson">Geometry Json</Translate>
              </span>
            </dt>
            <dd>{geometryEntity.geometryJson}</dd>
          </dl>
          <Button tag={Link} to="/entity/geometry" replace color="info">
            <FontAwesomeIcon icon="arrow-left" />{' '}
            <span className="d-none d-md-inline">
              <Translate contentKey="entity.action.back">Back</Translate>
            </span>
          </Button>&nbsp;
          <Button tag={Link} to={`/entity/geometry/${geometryEntity.id}/edit`} replace color="primary">
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

const mapStateToProps = ({ geometry }: IRootState) => ({
  geometryEntity: geometry.entity
});

const mapDispatchToProps = { getEntity };

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(GeometryDetail);
